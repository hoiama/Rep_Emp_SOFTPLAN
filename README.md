<h2><p align="center"> Sistema de orçamento de Estradas</p></h2>


OBJETIVO:

	Desenvolver sistema de consulta de valores envolvendo 
	
	- Custo com veículo
	- Quilometro de estrada
	- Peso da carga transportada


TECNOLOGIAS:
	
	- SpringBoot
	- Angular 1.75
	- Servidor Tomcat 9
	- Gradle
	- RestFull
	- Mock

	
	Interface principal;
<p align="center"><img src="/Sienge/0_Printscreen/1.png" width="950"/></p>

	Zoom da tela principal;
<p align="center"><img src="/Sienge/0_Printscreen/2.png" width="950"/></p>

<p>


CONCLUÍDO:

	

	- Consulta de custo por quilometro de estada Não pavimentada:
	
		GET: http://localhost:8080/street/nao-pavimentada?kilometer=100



	
	- Consulta de custo por quilometro de estrada Pavimentada:
	
		GET: http://localhost:8080/street/pavimentada?kilometer=100


	

	- Consulta por custo de cada tipo de veículo:
	
		GET: http://localhost:8080/vehicle?typeVehicle=cacamba&costWithKilometer=100




	- Consulta de custo referente ao peso ("tonelada") da carga transportada.

		GET: http://localhost:8080/charge?kilometer=100&weight=8



	- Consulta de custo por kilometros de estrada, recebe lista de objeto contendo 
	estrada pavimentada e não pavimentada.

		POST: http://localhost:8080/street
		
		Body:
		
		[
		  {
		      "typeStreet": "Pavimentada",
		      "kilometer": 100
		  },
		  {
		      "typeStreet": "Não pavimentada",
		      "kilometer": 0
		  }
		]




	

FALTA CONCLUIR:
	
	- PlaceHolder dos imputs.
	- Finalizar Validação frontEnd via angular.
	- Integrar da validação do frontEnd com o response do Back.
	- Diagramas UML (classe, caso de uso) caso haja tempo.
	- Implementar padrões de projetos  "Strategy" no back para veiculos.
	- Viabilizar alteração de Taxas via frontEnd direto no banco de dados.



INSTRUÇÕES DE USO:

	- Acessar plasta "Application"
	- Executar comando "java -jar Sienge-0.0.1-SNAPSHOT.jar" ou "java -jar Sienge-0.0.1-SNAPSHOT.war" 
	- Abrir browser e digitar  "http://localhost:8080" 



OBSERVAÇÕES

	- Projeto em desenvolvimento.
	- Dependencias via "npm" no seguinte path:/Sienge/src/main/resources/static/framework/npm

</p>
