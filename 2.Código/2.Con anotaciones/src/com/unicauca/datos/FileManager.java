package com.unicauca.datos;

import java.io.File;
import java.io.IOException;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sahydo
 */
public class FileManager implements DataAccessStrategy {
	private Path filePath;
	private final String dataPackage = "gamesData";
	private final String separator = "/";
	private final String gameCountFile = "count-game.txt";

	public Path getFilePath() {
		return filePath;
	}

	public void setFilePath(Path filePath) {
		this.filePath = filePath;
	}

	public String getDataPackage() {
		return dataPackage;
	}

	public void createFile(String path, List<String> data) {
		List<String> lines = data;
		String pathFile = dataPackage + separator + path;
		createDirectory(new File(dataPackage));
		filePath = Paths.get(pathFile);
		try {
			Files.write(filePath, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<String> readFile(String path) {
		List<String> lines = null;
		String pathFile = dataPackage + separator + path;
		createDirectory(new File(dataPackage));
		filePath = Paths.get(pathFile);
		try {
			lines = Files.readAllLines(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lines;
	}

	private int getGameNumber() {
		List<String> lines = null;
		String pathFile = dataPackage + separator + gameCountFile;
		int numberOfGames;
		createDirectory(new File(dataPackage));
		filePath = Paths.get(pathFile);
		try {
			lines = Files.readAllLines(filePath);
			numberOfGames = Integer.parseInt(lines.get(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			numberOfGames = 0;
		}
		return numberOfGames;
	}

	private void setGameNumber(int numberOfGames) {
		List<String> lines = Arrays.asList(String.valueOf(numberOfGames));
		String pathFile = dataPackage + separator + gameCountFile;
		createDirectory(new File(dataPackage));
		filePath = Paths.get(pathFile);
		try {
			Files.write(filePath, lines, Charset.forName("UTF-8"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createDirectory(File directory) {
		if (!directory.exists()) {
			System.out.println("Creando directorio: " + directory.getName());
			boolean result = false;

			try {
				directory.mkdir();
				result = true;
			} catch (SecurityException se) {
				System.out.println("No se pudo crear el directorio: " + directory.getName());
			}
			if (result) {
				System.out.println("Directorio creado");
			}
		}
	}

	/**
	 * @param resultado
	 *            Es el resultado del juego y el estado del tablero
	 */
	public List<String> convertData(Result resultado) {
		ArrayList<String> lines = new ArrayList<>();
		lines.add(String.valueOf(resultado.getId()));
		lines.add(resultado.getGanadorName());
		lines.add(resultado.getNombreJuego());
		lines.add(String.valueOf(resultado.getFilas()));
		lines.add(String.valueOf(resultado.getColumnas()));
		lines.add(String.valueOf(resultado.getNumeroCasillas()));
		lines.add(String.valueOf(resultado.getJugador1()));
		lines.add(String.valueOf(resultado.getJugador2()));
		lines.add(String.valueOf(resultado.getGanador()));
		int matriz[][] = resultado.getMatrizTablero();
		String cadena = "";
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if (j == (matriz[i].length - 1)) {
					cadena = cadena + matriz[i][j];
				} else {
					cadena = cadena + matriz[i][j] + "-";
				}
			}
			cadena = cadena + ",";
		}
		lines.add(cadena);
		return lines;

	}

	public Result convertData(List<String> data) {
		Result result = new Result();
		result.setId(Integer.parseInt(data.get(0)));
		result.setGanadorName(data.get(1));
		result.setNombreJuego(data.get(2));
		result.setFilas(Integer.parseInt(data.get(3)));
		result.setColumnas(Integer.parseInt(data.get(4)));
		result.setNumeroCasillas(Integer.parseInt(data.get(5)));
		result.setJugador1(Integer.parseInt(data.get(6)));
		result.setJugador2(Integer.parseInt(data.get(7)));
		result.setGanador(Integer.parseInt(data.get(8)));
		int matriz[][] = new int[result.getFilas()][result.getColumnas()];
		String[] matrizDatos = data.get(9).split(",");
		for (int i = 0; i < matrizDatos.length; i++) {
			String[] line = matrizDatos[i].split("-");
			for (int j = 0; j < line.length; j++) {
				matriz[i][j] = Integer.parseInt(line[j]);

			}
		}
		result.setMatrizTablero(matriz);
		return result;
	}

	@Override
	public ArrayList<Result> getResults() {
		ArrayList<Result> results = new ArrayList<>();
		ArrayList<String> fileNames = new ArrayList<>();
		String path = this.getDataPackage();
		File dir = new File(path);
		File[] files = null;
		if (dir.exists()) {
			files = dir.listFiles();
			for (int i = 1; i < files.length; i++) {
				fileNames.add(files[i].getName());
			}
		}
		for (String filename : fileNames) {
			List<String> data = this.readFile(filename);
			results.add(this.convertData(data));
		}
		return results;
	}

	@Override
	public boolean saveData(Result resultado) {
		this.setGameNumber(this.getGameNumber() + 1);
		resultado.setId(this.getGameNumber());
		this.createFile("juego" + resultado.getId() + "_" + resultado.getGanadorName() + ".txt",
				this.convertData(resultado));
		return true;
	}
}
