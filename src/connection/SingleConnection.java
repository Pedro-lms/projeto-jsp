package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

		private static String banco = "jdbc:postgresql://localhost:5432/curso-jsp?autoReconnect=true";
		private static String password = "1234";
		private static String user = "admin";
		private static Connection connection = null;
		
		static {
			conectar();
		}
		
		public SingleConnection(){
			conectar();
		}

		private static void conectar() {

			try {
				if(connection == null) {
					Class.forName("org.postgreesql.Driver");
					connection = DriverManager.getConnection(banco, user, password);
				}
			}catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException("Erro ao conectar com o banco de dados");
			}
			
		}
		
		public static Connection getConnection() {
			return connection;
		}
}


