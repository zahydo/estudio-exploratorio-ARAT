package com.unicauca.negocio.modelo.patrones.observer;

import java.util.ArrayList;

/**
 * @author Sahydo
 * 
 *         Patron Observer, esta clase representa al observado
 */
public abstract class Subject {
	private ArrayList<Observer> observers;

	public void addObserver(Observer observer) {
		if (observers == null) {
			observers = new ArrayList<>();
		}
		observers.add(observer);
	}

	public void delObserver(Observer observer) {
		if (observers != null) {
			if (observers.contains(observer)) {
				observers.remove(observer);
			}
		}
	}

	public void notifyObservers() {
		if (observers != null) {
			for (Observer observer : observers) {
				observer.update();
			}
		}
	}
}
