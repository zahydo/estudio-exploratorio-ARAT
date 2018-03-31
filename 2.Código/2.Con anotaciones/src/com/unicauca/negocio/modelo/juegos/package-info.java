/**
 * 
 */
/**
 * @author Sahydo
 *
 */
@Rationale(componentName = "games", id = "pkg-games", motivation = "Mantenibilidad -> Capacidad para ser modificado, crear nuevos tipos de juegos sin modificar el codigo existente", justification = "Las clases subtipos de Juego se crean por reflexion a traves del FactoryMetodh en el metodo "
		+ "del JuegoController 'iniciarJuego' especificando la direccion de este paquete en una variable")
package com.unicauca.negocio.modelo.juegos;

import org.unicauca.annotations.model.Rationale;
