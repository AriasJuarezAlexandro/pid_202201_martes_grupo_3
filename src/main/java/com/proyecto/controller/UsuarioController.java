package com.proyecto.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.proyecto.entity.Administrador;
import com.proyecto.entity.Usuario;
import com.proyecto.service.AdministradorService;
import com.proyecto.service.UsuarioService;

@Controller
public class UsuarioController {

	
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private AdministradorService administradorService;
	
	@RequestMapping(value = {"" , "/" , "/login"})
	public String loginPage() {
		System.out.println("Entrando a pagina login");
		return "login";
	}
	
	@RequestMapping(value = "/registro")
	public String registroPage(@ModelAttribute("administrador") Administrador admin) {
		System.out.println("Entrando a pagina registro");
		return "registro";
	}
	
	@PostMapping(value = "/registrarUsuario")
	public String registroUsuario(@Valid @ModelAttribute("administrador") Administrador admin ,
									BindingResult result,
									@RequestParam("password") String password ,
									@RequestParam("confirmPassword") String confirmPassword,
									RedirectAttributes redirect) throws Exception {
		System.out.println("Registrando");
		try {
			if (result.hasErrors()) {
				return "/registro";
			}
			
			if(password.equals(confirmPassword)) { //Contraseñas coinciden
				Administrador temp = administradorService.buscarAdministradorPorDni(admin.getDni());
				if(temp == null) {	 //No existe otro usuario con el mismo dni	
					temp = administradorService.buscarAdministradorPorEmail(admin.getEmail());
						if (temp == null) { //No existe otro usuario con el mismo email
							Usuario user = new Usuario();
							user.setUsername(admin.getEmail());
							user.setPassword(password);
							user.setFecha_registro(new Date());
							usuarioService.registrarUsuario(user);
							
							admin.setUsuario(user);
							administradorService.registrarAdministrador(admin);
						}else {
							redirect.addFlashAttribute("advertencia","El correo ya existe");
							return "redirect:/registro";
						}
				}else {
					redirect.addFlashAttribute("advertencia","El Dni ya existe");
					return "redirect:/registro";
				} 
			}else {
				redirect.addFlashAttribute("advertencia","Las Contraseñas no coinciden");
				return "redirect:/registro";
			}
		} catch (Exception e) {
			redirect.addFlashAttribute("error","Error al registrar");
			e.printStackTrace();
			return "redirect:/registro";
		}
		
		redirect.addFlashAttribute("mensaje","Usuario registrado correctamente");
		return "redirect:/registro";
	}
}
