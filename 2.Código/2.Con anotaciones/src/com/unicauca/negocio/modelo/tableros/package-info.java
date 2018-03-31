/**
 * 
 */
/**
 * @author Sahydo
 *
 */
@Rationale(componentName = "boards", id = "pkg-boards", motivation = "Mantenibilidad -> Capacidad para ser modificado, crear nuevos tipos de tableros de acuerdo a un tipo de Juego", justification = "Las clases subtipos de Tablero se crean por reflexion a traves del FactoryMetodh en el metodo "
		+ "del Juego 'iniciarJuego' especificando la direccion de este paquete en una variable")
package com.unicauca.negocio.modelo.tableros;

import org.unicauca.annotations.model.Rationale;
