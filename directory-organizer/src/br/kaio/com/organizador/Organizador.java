package br.kaio.com.organizador;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

public class Organizador {
	private static final String PASTA_DOWNLOADS = "C:\\Users\\Kaio\\Downloads\\";
	private static final String PASTA_ORGANIZADA = PASTA_DOWNLOADS + "Organizada\\";

	private static final Map<String, String> categorias = new HashMap<String, String>();

	static {
		categorias.put(".pdf", "Documentos");
		categorias.put(".doc", "Documentos");
		categorias.put(".docx", "Documentos");
		categorias.put(".txt", "Documentos");
		categorias.put(".xls", "Planilhas");
		categorias.put(".xlsx", "Planilhas");
		categorias.put(".ppt", "Apresentacoes");
		categorias.put(".pptx", "Apresentacoes");

		categorias.put(".jpg", "Imagens");
		categorias.put(".jpeg", "Imagens");
		categorias.put(".png", "Imagens");
		categorias.put(".gif", "Imagens");
		categorias.put(".svg", "Imagens");
		categorias.put(".webp", "Imagens");
		categorias.put(".ico", "Imagens");

		categorias.put(".mp3", "Audio");
		categorias.put(".wav", "Audio");
		categorias.put(".ogg", "Audio");

		categorias.put(".mp4", "Videos");
		categorias.put(".avi", "Videos");
		categorias.put(".mkv", "Videos");
		categorias.put(".mov", "Videos");

		categorias.put(".zip", "Compactados");
		categorias.put(".rar", "Compactados");
		categorias.put(".7z", "Compactados");
		categorias.put(".tar", "Compactados");

		categorias.put(".exe", "Executaveis");
		categorias.put(".msi", "Executaveis");
		categorias.put(".bat", "Executaveis");

		categorias.put(".java", "Codigos Java");
		categorias.put(".class", "Codigos Java");
		categorias.put(".jar", "Codigos Java");

		categorias.put(".html", "Sites");
		categorias.put(".css", "Sites");
		categorias.put(".js", "JavaScript");
		categorias.put(".ts", "TypeScript");
		categorias.put(".jsx", "React");
		categorias.put(".tsx", "React");

		categorias.put(".py", "Python");
		categorias.put(".php", "PHP");
		categorias.put(".sql", "Banco de Dados");
		categorias.put(".json", "APIs e JSON");
		categorias.put(".xml", "APIs e XML");
		categorias.put(".yml", "Configuracoes");
		categorias.put(".yaml", "Configuracoes");

		categorias.put(".cpp", "C e C++");
		categorias.put(".c", "C e C++");
		categorias.put(".h", "C e C++");

		categorias.put(".cs", "CSharp");
		categorias.put(".go", "Golang");
		categorias.put(".rb", "Ruby");
		categorias.put(".kt", "Kotlin");
		categorias.put(".swift", "Swift");

		categorias.put(".apk", "Android");
		categorias.put(".iso", "ISO");
	}

	public static void main(String[] args) {

		try {
			Path downloads = Paths.get(PASTA_DOWNLOADS);
			try (DirectoryStream<Path> stream = Files.newDirectoryStream(downloads)) {
				for (Path arquivo : stream) {
					if (Files.isDirectory(arquivo))
						continue;

					String nomeArquivo = arquivo.getFileName().toString().toLowerCase();

					for (String ext : categorias.keySet()) {
						if (nomeArquivo.endsWith(ext)) {
							Path pastaDestino = Paths.get(PASTA_ORGANIZADA, categorias.get(ext));

							Files.createDirectories(pastaDestino);

							Files.move(arquivo, pastaDestino.resolve(arquivo.getFileName()),
									StandardCopyOption.REPLACE_EXISTING);
							System.out.println("Movido: " + nomeArquivo);
						}
						System.out.println("Faxina concluída!");
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
