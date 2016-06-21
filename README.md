Exemple de Spring Boot

pour installer Spring Boot il faut :
 - JDK (au moins version 7)
 - maven ou Gradle (dans notre exemple on va travailler avec maven)
 
les étapes a suivre :
1- crée un projet maven
2- dans le fichier pom ajouté les dépendances suivantes :
	
<parent> 
	<groupId>org.springframework.boot</groupId> 
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>1.1.4.RELEASE</version>
</parent>

<dependencies>
      <dependency> <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-starter-web</artifactId>
      </dependency>
      <dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
</dependencies>


3- crée une classe qui sera appelée au démarrage de l'application, Ex :

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	public static void main(String[] args) throws Exception {
    	SpringApplication.run(Application.class, args);
	}
}  

Avec spring 3, il est possible de configurer le contexte en utilisant des annotations au lieu du fichier de configuration XML.

Explication des annotations :

@Configuration : Les classes où elle est apposée se substituent en effet aux traditionnels fichiers de configuration XML. Nous y retrouvons la déclaration de beans Spring, l’import de fichiers ou de classes de configuration.

Les classes annotées avec @Configuration doivent respecter certaines contraintes :

ne doivent pas être final
ne peuvent pas être déclarées dans une méthode d'une autre classe
doivent avoir un constructeur par défaut sans paramètre
ne peuvent pas utiliser l'annotation @Autowired sur les paramètres de leurs constructeurs.

@EnableAutoConfiguration : La présence de cette annotation sur la classe Application informe Boot qu'il doit adopter une approche dogmatique de la configuration pour l'application. Cette option fixe la configuration aux valeurs par défaut définies par le framework, ce qui permet d'obtenir une application fonctionnelle le plus rapidement possible. La classe Application est exécutable, ce qui veut dire que l'application, et son conteneur embarqué, peuvent être démarrés et développés activement en choisissant de démarrer la classe en tant qu'application Java.

@ComponentScan : prend comme paramètre "basePackages" qui définie les packages java a scanné.

SpringApplication.run() : méthode qui lance l'application, elle retourne ApplicationContext qui contient toutes les beans crées par cette application.

4- le contrôleur 

Il nous reste plus qu'une seul chose : le contrôleur.

Il s'agit d'un contrôleur classique pour ceux qui connaissent Spring MVC. Et grâce à Spring 4, il n'y a plus besoin d'effectuer la conversion Objet vers JSON et inversement. Le marshaling et le unmarshaling sont effectués par Spring et grâce à l'annotation @RestController.

@RestController 
@RequestMapping(value ="/application") 
public class ApplicationController {
 
	@RequestMapping(method = RequestMethod.GET)
	public String getMSG() {
 		return "Bonjour tout le monde";	
	}
 
	@RequestMapping(value = "/{shortName}", method = RequestMethod.GET)
	public String getMSGShortName(@PathVariable(value = "shortName") String shortName) {
 		return "Bonjour : "+ shortName;
	}
}

Remarque : je ne vais pas expliquer les autres annotations de spring (peut être dans un autre exemple)
 