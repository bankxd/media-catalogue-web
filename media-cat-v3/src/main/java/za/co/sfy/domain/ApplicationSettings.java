package za.co.sfy.domain;

public class ApplicationSettings {
	private String backgroundColour1;
	private String backgroundColour2;
	private String fontStyle;

	public ApplicationSettings() {
		this.backgroundColour1 = "green";
		this.backgroundColour2 = "lime";
		this.fontStyle = "Arial";
	}

	public String getBackgroundColour1() {
		return backgroundColour1;
	}

	public void setBackgroundColour1(String backgroundColour1) {
		this.backgroundColour1 = backgroundColour1;
	}

	public String getBackgroundColour2() {
		return backgroundColour2;
	}

	public void setBackgroundColour2(String backgroundColour2) {
		this.backgroundColour2 = backgroundColour2;
	}

	public String getFontStyle() {
		return fontStyle;
	}

	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}

}
