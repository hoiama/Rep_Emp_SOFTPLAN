<h2><p align="center"> Sistema de orçamento de Estradas</p></h2>


OBJETIVO:

	Desenvolver sistema de consulta de valores envolvendo 
	
	- Custo com veículo
	- kilometros de estrada
	- Peso da carga tranpostada


TECNOLOGIAS:
	
	- SpringBoot
	- Angular 1
	- Servidor Tomcat 9
	- Gradle
	- RestFull

	
	Interface principal;
<p align="center"><img src="/Sienge/0_Printscreen/1.png" width="950"/></p>

	Zoom da tela principal;
<p align="center"><img src="/Sienge/0_Printscreen/2.png" width="950"/></p>

<p>


CONCLUÍDO:

	- Consulta de custo por kilometros de estrada, recebe lista de objeto contendo estrada pavimentada e não pavimentada.

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




	- Consulta de custo por quilometro de estada Não pavimentada:
	
		GET: http://localhost:8080/street//nao-pavimentada?kilometer=100



	
	- Consulta de custo por quilometro de estrada Pavimentada:
	
		GET: http://localhost:8080/street/pavimentada?kilometer=100


	

	- Consulta por custo de cada tipo de veículo:
	
		GET: http://localhost:8080/vehicle?typeVehicle=cacamba&costWithKilometer=100




	- Consulta de custo referente ao peso ("tonelada") da carga transportada.

		GET: http://localhost:8080/charge?kilometer=100&weight=8


	

FALTA CONCLUIR:
	
	- Finalizar Validação frontEnd.
	- Integrar Validação do backend como Front.
	- Diagramas UML.
	- Documentar levantamento de requisitos.
	- Implementar padrões de projetos  "Strategy".
	- Testes Unitários Backend.
	- Viabilizar alteração de Taxas via frontEnd.


OBSERVAÇÕES

	- Projeto em desenvolvimento.
	- Antes de executar será necessário instalar as dependencias via "npm" no seguinte path:
		/Sienge/src/main/resources/static/framework/npm

</p>
