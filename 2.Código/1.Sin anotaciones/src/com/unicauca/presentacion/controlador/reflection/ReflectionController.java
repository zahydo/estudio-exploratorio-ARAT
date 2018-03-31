package com.unicauca.presentacion.controlador.reflection;

import java.util.ArrayList;
import java.util.Set;

import org.reflections.Reflections;

import com.unicauca.negocio.modelo.juegos.Juego;

/**
 * @author Sahydo
 * 
 *         Esta clase permite optener las clases que heredan de Juego a traves
 *         de reflexion
 */
public class ReflectionController {
	// Utilizamos lib/reflections-0.9.9-RC1.jar para obtener las clases subtipo de
	// Juego
	public static Set<Class<? extends Juego>> getTiposDeJuego() {
		Reflections reflections = new Reflections("com");
		Set<Class<? extends Juego>> classes = reflections.getSubTypesOf(Juego.class);
		return classes;
	}

	/**
	 * @return Lista con los nombres de los tipos que heredan de Juego
	 */
	public static ArrayList<String> getListaJuegos() {
		ArrayList<String> classNames = new ArrayList<>();
		for (Class<? extends Juego> class1 : getTiposDeJuego()) {
			classNames.add(class1.getSimpleName());
		}
		return classNames;
	}
}
