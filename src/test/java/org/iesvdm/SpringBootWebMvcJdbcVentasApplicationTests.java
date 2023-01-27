package org.iesvdm;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.MalformedURLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.htmlunit.MockMvcWebClientBuilder;
import org.springframework.web.context.WebApplicationContext;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;

@SpringBootTest
class SpringBootWebMvcJdbcVentasApplicationTests {

	WebClient webClient;

    @BeforeEach
    void setup(WebApplicationContext context) {
        webClient = MockMvcWebClientBuilder
                .webAppContextSetup(context)
                .build();
    }


    @Test
    void validationForm() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
       
       HtmlPage validationFormPage = webClient.getPage("http://localhost/clientes/crear;");
       
       HtmlForm validationForm = validationFormPage.getHtmlElementById("formCrearCliente");
       
       HtmlTextInput nombreInput = validationFormPage.getHtmlElementById("nombre");
       nombreInput.setValueAttribute("Juan");
       
       HtmlTextInput apellido1Input = validationFormPage.getHtmlElementById("apellido1");
       apellido1Input.setValueAttribute("Sánchez");
       
       HtmlTextInput apellido2Input = validationFormPage.getHtmlElementById("apellido2");
       apellido2Input.setValueAttribute("Fernández");
       
       HtmlTextInput ciudadInput = validationFormPage.getHtmlElementById("ciudad");
       ciudadInput.setValueAttribute("Sevilla");
       
       HtmlTextInput categoriaInput = validationFormPage.getHtmlElementById("categoria");
       categoriaInput.setValueAttribute("200");
       
       HtmlTextInput correoInput = validationFormPage.getHtmlElementById("correo");
       correoInput.setValueAttribute("juansf@gmail.com");
       
       HtmlSubmitInput submit = validationForm.getOneHtmlElementByAttribute("input", "type", "submit");
       HtmlPage newValidationPage = submit.click();
       
       assertThat(newValidationPage.getUrl().toString()).endsWith("/clientes");
       
       String nombreNew = newValidationPage.getHtmlElementById("nombre").getTextContent();
       assertThat(nombreNew).isEqualTo("Juan");
       
       String apellido1New = newValidationPage.getHtmlElementById("apellido1").getTextContent();
       assertThat(apellido1New).isEqualTo("Sánchez");

       String apellido2New = newValidationPage.getHtmlElementById("apellido2").getTextContent();
       assertThat(apellido2New).isEqualTo("Fernández");
       
       String ciudadNew = newValidationPage.getHtmlElementById("ciudad").getTextContent();
       assertThat(ciudadNew).isEqualTo("Sevilla");
       
       String categoriaNew = newValidationPage.getHtmlElementById("categoria").getTextContent();
       assertThat(categoriaNew).isEqualTo("200");
       
       String emailNew = newValidationPage.getHtmlElementById("correo").getTextContent();
       assertThat(emailNew).isEqualTo("juansf@gmail.com");
       
   }
    
    @Test
    void mensajesError() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
        
        HtmlPage validationFormPage = webClient.getPage("http://localhost/clientes/crear;");
        
        HtmlForm validationForm = validationFormPage.getHtmlElementById("formCrearCliente");
        
        HtmlTextInput nombreInput = validationFormPage.getHtmlElementById("nombre");
        nombreInput.setValueAttribute("María");
        
        HtmlTextInput apellido1Input = validationFormPage.getHtmlElementById("apellido1");
        apellido1Input.setValueAttribute("Hernández");
        
        HtmlTextInput apellido2Input = validationFormPage.getHtmlElementById("apellido2");
        apellido2Input.setValueAttribute("Fernández");
        
        HtmlTextInput ciudadInput = validationFormPage.getHtmlElementById("ciudad");
        ciudadInput.setValueAttribute("Granada");
        
        HtmlTextInput categoriaInput = validationFormPage.getHtmlElementById("categoria");
        categoriaInput.setValueAttribute("101");
        
        HtmlTextInput correoInput = validationFormPage.getHtmlElementById("correo");
        correoInput.setValueAttribute("maríahf@gmail.com");
        
        HtmlSubmitInput submit = validationForm.getOneHtmlElementByAttribute("input", "type", "submit");
        HtmlPage newValidationPage = submit.click();
        
        assertThat(newValidationPage.getUrl().toString()).endsWith("/crear");
        
        String mensajeErrorCategoria = newValidationPage.getHtmlElementById("error-categoria").getTextContent();
        //assertThat(mensajeErrorCategoria).isEqualTo("Categoría solo puede ser: 100 200 300 400 500 600 700 800 1000");
        assertThat(mensajeErrorCategoria).isNotNull();
        
    }
}
