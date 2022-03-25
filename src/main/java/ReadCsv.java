import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ReadCsv {
	String line = "";
	String[] currentLine;
	List<Show> listOfMovies = new ArrayList<>();

	public void readCsv(String filePath) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			while ((this.line = reader.readLine()) != null) {
				this.currentLine = this.line.split(",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)");
				Show show = new Show(
						this.currentLine[0].replaceAll("^\"|\"$", ""),
						this.currentLine[1].replaceAll("^\"|\"$", ""),
						this.currentLine[2].replaceAll("^\"|\"$", ""),
						this.currentLine[3].replaceAll("^\"|\"$", ""),
						this.currentLine[4].replaceAll("^\"|\"$", ""),
						this.currentLine[5].replaceAll("^\"|\"$", ""),
						this.currentLine[6].replaceAll("^\"|\"$", "")
				);
				this.listOfMovies.add(show);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getData(String fieldType, String fieldValue, String Country) {
		try {
			int count = 0;
			Scanner sc = new Scanner(System.in);

			System.out.println("Enter the Number of records you want to fetch \n");
			int numberOfRecords = Integer.parseInt(sc.next());

			System.out.println("Enter Start Date And End Date in dd-MM-YY format");
			String date1 = "";
			date1 = sc.next();
			Date startDate;

			startDate = new SimpleDateFormat("dd-MM-yy").parse(date1);

			date1 = sc.next();
			Date endDate;

			endDate = new SimpleDateFormat("dd-MM-yy").parse(date1);

			while (numberOfRecords > 0 && count < this.listOfMovies.size()) {
				Show currentObj = this.listOfMovies.get(count);
				if (
					this.listOfMovies.get(count).getReleaseDate()!=null &&
					this.listOfMovies.get(count).getReleaseDate().compareTo(startDate) >= 0 &&
					this.listOfMovies.get(count).getReleaseDate().compareTo(endDate) <= 0
				) {
					if (fieldType.toLowerCase().equals("type")
							&& fieldValue.toLowerCase().equals(this.listOfMovies.get(count).getType().toLowerCase())
							&& Country.toLowerCase().equals("all")) {
						this.displayRecord(currentObj);
						System.out.println(
								"--------------------------------------------------------------------------------------------------------------------------");
						numberOfRecords -= 1;
					} else if (fieldType.toLowerCase().equals("type")
							&& fieldValue.toLowerCase().equals(this.listOfMovies.get(count).getType().toLowerCase())
							&& Country.toLowerCase().equals(this.listOfMovies.get(count).getCountry().toLowerCase())) {
						this.displayRecord(currentObj);
						System.out.println(
								"--------------------------------------------------------------------------------------------------------------------------");
						numberOfRecords -= 1;
					} else if (fieldType.toLowerCase().equals("genre")
							&& Arrays.asList(this.listOfMovies.get(count).getGenre().toLowerCase().split(","))
									.contains(fieldValue.toLowerCase())) {
						this.displayRecord(currentObj);
						System.out.println(
								"--------------------------------------------------------------------------------------------------------------------------");
						numberOfRecords -= 1;
					}
				}
				count += 1;
			}
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void displayRecord(Show show) {
		System.out.println("ID		:" + show.getId());
		System.out.println("Type		:" + show.getType());
		System.out.println("Name		:" + show.getName());
		System.out.println("Director	:" + show.getDirector());
		System.out.println("Country		:" + show.getCountry());
		System.out.println("release Date:" + show.getReleaseDate());
		System.out.println("Genre		:" + show.getGenre());
	}

}
