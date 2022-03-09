// 1 - Pacote
package testerestassured;

// 2 - Bibliotecas

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

// 3 - Classe
public class Desafio {
    // 3.1 - Atributos (adjetivos e características de um objeto. Ex: Pessoa altura, idade, peso e etc)
    String uri = "https://petstore.swagger.io/v2/pet"; //Endereço da entidade PET


    // 3.2 - Métodos e Funções (Métodos ações que não retornam valor e funções elas fazem ações e devolvem resultado
    public String lerJason(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test //Identifica o método ou função como um teste para o TestNG ou JUnit
    public void incluirPet() throws IOException {
        String jsonBody = lerJason("db/pet1.json");

        // Sintaxe Gherkin
        // Dado - Quando - Então
        // Given - When - Then


        given()
                .contentType("application/json") //Comum em API REST as antigas eram text/xml
                .log().all()
                .body(jsonBody)
        .when()
                .post(uri)
        .then()
                .log().all()
                .statusCode(200)
        ;

    }

}
