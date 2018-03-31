package com.unicauca.datos;

import java.util.ArrayList;

public interface DataAccessStrategy {
	public abstract boolean saveData(Result resultado);

	public abstract ArrayList<Result> getResults();
}
