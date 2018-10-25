<h1>Estudio exploratorio sobre ARAT</h1>
<p>
	En este respositorio se encuentran todos los archivos necesarios para llevar a cabo la ejecución
	de un estudio exploratorio enfocado en la verificación de la utilidad de una herramienta Software
	basada en anotaciones de código fuente Java, como una forma rápida y efectiva de documentar las razones de las decisiones arquitecturales, más conocidas como Rationale Arquitectónico.
</p>
<p>
	 El objetivo de este experimento es analizar la documentación del rationale arquitectónico a través de anotaciones de código, con el propósito de determinar el valor de las anotaciones de código como herramienta para documentar el rationale arquitectónico con respecto a la mantenibilidad de la arquitectura en términos de eficiencia y efectividad.
</p>
<h2>Hipótesis</h2>
<ol>
	<li>
		Efectividad
		<ol>
			<li>
				<h3>Hipótesis nula</h3>
				<p>La efectividad al realizar un cambio arquitectural en un sistema con la documentación del Rationale arquitectónico en anotaciones de código, es menor o igual a la efectividad de realizar el cambio sin anotaciones de código.
				</p>
			</li>
			<li>
				<h3>Hipótesis alternativa</h3>
				<p>La efectividad al realizar un cambio arquitectural en un sistema con la documentación del Rationale arquitectónico en anotaciones de código, es mayor a la efectividad de realizar el cambio sin anotaciones de código.</p>
			</li>
		</ol>
	</li>
	<li>
		Eficiencia
		<ol>
			<li>
				<h3>Hipótesis nula</h3>
				<p>La eficiencia al realizar un cambio arquitectural en un sistema con la documentación del Rationale arquitectónico en anotaciones de código, es menor o igual a la eficiencia de realizar el cambio sin anotaciones de código.</p>
			</li>
			<li>
				<h3>Hipótesis alternativa</h3>
				<p>La eficiencia al realizar un cambio arquitectural en un sistema con la documentación del Rationale arquitectónico en anotaciones de código, es mayor a la eficiencia de realizar el cambio sin anotaciones de código.</p>
			</li>
		</ol>
	</li>
</ol>

<h2>Variables</h2>
<ol>
	<li>
		Varibles independientes:
		<ol>
			<li>Presencia de las anotaciones de código con información del Rationale Arquitectónico(variable categórica)</li>
		</ol>
	</li>
	<li>
		Varibles dependientes:
		<ol>
			<li>Eficiencia: ((Nivel de Correctitud Total)/(Total de tiempo empleado))/(Nivel de Correctitud Total de Referencia) </li>
			<li>Efectividad: (Nivel de Correctitud Total)/(Nivel de Correctitud Total esperado) </li>
		</ol>
	</li>
</ol>

<h2>Materiales</h2>
Para este experimento se hace uso de los siguientes recursos informáticos:
<ul>
	<li>
		Alguno de estos IDE (Integrated Development Environment):
		<ul>
			<li><a href="https://netbeans.org/downloads/" target="_blank">NetBeans</a></li>
			<li><a href="https://www.eclipse.org/downloads/" target="_blank">Eclipse</a></li>
		</ul>
	</li>
	<li>
		El modelador de Software: 
		<ul>
			<li><a href="http://staruml.io/download" target="_blank">StarUML</a></li>
		</ul>
	</li>
	<li>
		Las herramientas del Sistema Operativo
		<ul>
			<li>Visor de PDF</li>
			<li>Visor de imágenes</li>
		</ul>
	</li>
</ul>
<h2>Contenido del directorio</h2>
<ol>
	<li>
		Documentación
		<ul>
			<li>Diagramas en imágenes .png</li>
			<li>Diagramas en .mdj(StarUML)</li>
			<li>SAD: Software Architecture Document</li>
		</ul>
	</li>
	<li>
		Código fuente
		<ul>
			<li>Con anotaciones
				<ul>
					<li>com: Paquete con el código fuente y las anotaciones de códgigo</li>
					<li>lib: 7 librerías .jar utilidas para Reflexión y 1 .jar con el modelo de anotaciones ARAT</li>
				</ul>
			</li>
			<li>Sin anotaciones
				<ul>
					<li>com: Paquete con el código fuente</li>
					<li>lib: 7 librerías .jar utilidas para Reflexión</li>
				</ul>
			</li>
			</li>
		</ul>
	</li>
	<li>Ejemplo de una implementación de Sockets</li>
</ol>

<h3>Información de contacto</h3>
<p><strong>Sitio web:</strong> <a href="http://artemisa.unicauca.edu.co/~santiagodorado/" target="_blank">Santiago Hyun Dorado</a></p>
