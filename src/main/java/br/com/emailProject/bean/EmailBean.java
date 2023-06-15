package br.com.emailProject.bean;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.emailProject.dto.EmailLayout;
import br.com.emailProject.model.Email;
import br.com.emailProject.service.EmailService;

@Named
@RequestScoped
public class EmailBean implements Serializable {

	private static final long serialVersionUID = -2672111364130182594L;
	
	private static final String DESTINATARIO = "teste@teste.com";
	private static final String ASSUNTO = "teste";
	
	@Inject //Injeta dependecia da classe
	private EmailService emailService;
	
	public String enviarEmail() {
		emailService.enviar(montarEmail());
		return null;
	}

	public Email montarEmail() {
		EmailLayout layout = new EmailLayout();
		return layout.montarEmailAdministrador(DESTINATARIO, ASSUNTO);
	}
}
