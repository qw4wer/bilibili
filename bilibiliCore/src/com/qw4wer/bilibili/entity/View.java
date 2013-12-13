package com.qw4wer.bilibili.entity;

public class View {
	private  String offsite;
	private  String tag;
	private  String pages;
	private  String create_at;
	private Integer play;
	private  int favorites;
	private  String pic;
	private  String from;
	private  int cid;
	private  String author;
	private  int video_review;
	private  String title;
	private  int coins;
	private  boolean favorited;
	private  String description;
	private  int mid;
	private  int credit;
	private int review;
	
	private int aid;

	public void setOffsite( String offsite) {
		this.offsite = offsite;
	}

	public  String getOffsite() {
		return offsite;
	}

	public void setTag( String tag) {
		this.tag = tag;
	}

	public  String getTag() {
		return tag;
	}

	public void setPages( String pages) {
		this.pages = pages;
	}

	public  String getPages() {
		return pages;
	}

	public void setCreate_at( String create_at) {
		this.create_at = create_at;
	}

	public  String getCreate_at() {
		return create_at;
	}

	public void setPlay(Integer play) {
		this.play = play;
	}

	public Integer getPlay() {
		return play;
	}

	public void setFavorites( int favorites) {
		this.favorites = favorites;
	}

	public  int getFavorites() {
		return favorites;
	}

	public void setPic( String pic) {
		this.pic = pic;
	}

	public  String getPic() {
		return pic;
	}

	public void setFrom( String from) {
		this.from = from;
	}

	public  String getFrom() {
		return from;
	}

	public void setCid( int cid) {
		this.cid = cid;
	}

	public  int getCid() {
		return cid;
	}

	public void setAuthor( String author) {
		this.author = author;
	}

	public  String getAuthor() {
		return author;
	}

	public void setVideo_review( int video_review) {
		this.video_review = video_review;
	}

	public  int getVideo_review() {
		return video_review;
	}

	public void setTitle( String title) {
		this.title = title;
	}

	public  String getTitle() {
		return title;
	}

	public void setCoins( int coins) {
		this.coins = coins;
	}

	public  int getCoins() {
		return coins;
	}

	public void setFavorited( boolean favorited) {
		this.favorited = favorited;
	}

	public  boolean getFavorited() {
		return favorited;
	}

	public void setDescription( String description) {
		this.description = description;
	}

	public  String getDescription() {
		return description;
	}

	public void setMid( int mid) {
		this.mid = mid;
	}

	public  int getMid() {
		return mid;
	}

	public void setCredit( int credit) {
		this.credit = credit;
	}

	public  int getCredit() {
		return credit;
	}

	public void setReview(int review) {
		this.review = review;
	}

	public int getReview() {
		return review;
	}

	public int getAid() {
		return Integer.valueOf(offsite.substring(offsite.indexOf("=")+1, offsite.indexOf("&")));
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

}
