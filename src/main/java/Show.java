import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Show {
	private String id;
	private String type;
	private String name;
	private String director;
	private String country;
	private Date releaseDate;
	private String genre;

	public Show(String id, String type, String name, String director, String country, String releaseDate, String genre) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.director = director;
		this.country = country;
		this.genre = genre;
		this.releaseDate = this.parseDate(releaseDate);
	}

	Date parseDate(String dateString) {
		List<String> formatStrings = Arrays.asList("dd/MM/yy");
		for (String formatString : formatStrings)
		{
			try
			{
				return new SimpleDateFormat(formatString).parse(dateString);
			}
			catch (ParseException e) {}
		}
		return null;
	}

	public String getId() {
		return id;
	}

	public String getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public String getDirector() {
		return director;
	}

	public String getCountry() {
		return country;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public String getGenre() {
		return genre;
	}
}
