package com.pe.examen.controlador;

import java.util.List; 

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pe.examen.entidad.Cliente;
import com.pe.examen.entidad.Tipo;
import com.pe.examen.servicio.ClienteServicio;
import com.pe.examen.servicio.TipoServicio;

@Controller
public class ClienteController {

	@Autowired
	private ClienteServicio clienteServicio;
	
	@Autowired
	private TipoServicio tipoServicio;

	@RequestMapping("/verCliente")
	public String ver() {
		return "registraCliente";
	}
	
	@RequestMapping("/cargaTipo")
	@ResponseBody
	public List<Tipo> listaTipo() {
		return tipoServicio.listaTipo();
	}
	
	@RequestMapping("/registraCliente")
	public String metRegistra(Cliente obj,HttpSession session) {
		Cliente aux = clienteServicio.insertaCliente(obj);
		if(aux == null) {
			session.setAttribute("MENSAJE", "Registro erróneo");
		}else {
			session.setAttribute("MENSAJE", "Registro exitoso");
		}
		return "redirect:verCliente";
	}


	
	
}
