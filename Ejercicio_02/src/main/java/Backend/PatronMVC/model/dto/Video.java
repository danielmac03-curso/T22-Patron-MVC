package Backend.PatronMVC.model.dto;

public class Video {
	
	private Integer idVideo;
	private String titleVideo;
	private String directorVideo;
	private Integer cli_idVideo;

	/**
	 * @return the idVideo
	 */
	public Integer getIdVideo() {
		return idVideo;
	}
	
	/**
	 * @param setIdVideo the idVideo to set
	 */
	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}
	
	/**
	 * @return the titleVideo
	 */
	public String getTitleVideo() {
		return titleVideo;
	}
	
	/**
	 * @param setTitleVideo the titleVideo to set
	 */
	public void setTitleVideo(String titleVideo) {
		this.titleVideo = titleVideo;
	}
	
	/**
	 * @return the directorVideo
	 */
	public String getDirectorVideo() {
		return directorVideo;
	}
	
	/**
	 * @param setDirectorVideo the directorVideo to set
	 */
	public void setDirectorVideo(String directorVideo) {
		this.directorVideo = directorVideo;
	}
	
	/**
	 * @return the cli_idVideo
	 */
	public Integer getCli_idVideo() {
		return cli_idVideo;
	}
	
	/**
	 * @param setCli_idVideo the cli_idVideo to set
	 */
	public void setCli_idVideo(Integer cli_idVideo) {
		this.cli_idVideo = cli_idVideo;
	}
	

}
