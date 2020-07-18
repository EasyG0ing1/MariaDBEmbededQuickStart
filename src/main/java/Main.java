import ch.vorburger.exec.ManagedProcessException;
import ch.vorburger.mariadb4j.DB;
import ch.vorburger.mariadb4j.DBConfigurationBuilder;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class Main {
	private static final String                 USER_FOLDER    = System.getProperty("user.home");
	private static final String                 WORKING_FOLDER = "EmbeddedMariaDB";
	private static final String                 SCHEMA         = "MySchema";
	private static final int                    PORT           = 3307;
	public static        Connection             CONN;
	private static final String                 S              = "/";
	private static final String                 C              = ":";
	private static final File                   SCHEMA_FOLDER  = new File(USER_FOLDER + S + WORKING_FOLDER + S + SCHEMA);
	private static final DBConfigurationBuilder configBuilder  = DBConfigurationBuilder.newBuilder().setPort(PORT).setDataDir(USER_FOLDER + S + WORKING_FOLDER);

	public static void main(String[] args) {
		try {
			DB myDB = DB.newEmbeddedDB(configBuilder.build());
			myDB.start();
			if (!SCHEMA_FOLDER.exists()) myDB.createDB(SCHEMA);

			/*
			 * If you need to include a Connection in your app, the remaining code will build it
			 * for you. Leaving CONN public static will allow you to use a single Connection by
			 * referencing Main.CONN in your other classes.
			 */

			final String TIMEZONE_FIX = "?serverTimezone=" + TimeZone.getDefault().getID();
			final String JDBC_URL     = "jdbc:mysql://";
			final String HOST         = "localhost";
			final String USER         = "root";
			final String PASSWORD     = "";
			final String CONN_STRING  = JDBC_URL + HOST + C + PORT + S + SCHEMA + TIMEZONE_FIX;
			CONN = DriverManager.getConnection(CONN_STRING, USER, PASSWORD);
		}
		catch (ManagedProcessException e) {e.printStackTrace();}
		catch (SQLException e) {e.printStackTrace();}
	}
}
