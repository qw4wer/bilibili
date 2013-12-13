package com.qw4wer.bilibili.until;

import org.junit.Test;

public class BilibiliApi {

	/**
	 * 得到视频信息的地址
	 * 
	 * @param type
	 *            文件类型:<b>json</b> <b>xml</b>
	 * @param appKey
	 *            用户appkey
	 * @param avNum
	 *            Av号
	 * @param page
	 *            第几页
	 * @return 视频信息的地址
	 */
	public static String getMovieInfoPath(String type, String appKey,
			int avNum, int page) {
		String path = "http://api.bilibili.tv/view?type=" + type + "&appkey="
				+ appKey + "&id=" + avNum + "&page=" + page;
		return path;
	}

	/**
	 * 得到视频的下载地址
	 * 
	 * @param cid
	 *            API中提供的CID号
	 * @param format
	 *            文件类型（Flv,mp4）
	 * @return 视频的下载地址
	 * 
	 */
	public static String getMovieDownloadPath(String type, int cid,
			String format) {
		return "http://interface.bilibili.tv/playurl?otype=" + type + "&cid="
				+ cid + "&type=" + format;
	}

	/**
	 * @param keyWord
	 *            搜索关键字
	 * @param page
	 *            页码
	 * @param order
	 *            排序方式<br>
	 *            default 综合排序<br>
	 *            pubdate 按发布日期排序<br>
	 *            senddate 按修改日期排序<br>
	 *            id 按编号排序<br>
	 *            ranklevel 按相关度排序<br>
	 *            click 按点击排序<br>
	 *            scores 按评论数排序<br>
	 *            damku 按弹幕数排序<br>
	 *            stow 按收藏数排序<br>
	 * @return 搜索的地址
	 */
	public static String getSearchPath(String keyWord, int page, String order) {
		String path = "http://api.bilibili.tv/search?type=xml&appkey=0&keyword="
				+ keyWord + "&page=" + page + "&order=" + order;
		return path;
	}

	public static String getAssPath(int i) {
		return "http://comment.bilibili.tv/" + i + ".xml";
	}

	/**
	 * 黑科技地址
	 * @param cid
	 * @param aid
	 * @return
	 */
	public static String getPlayUrl(int cid,int aid){
		return "https://secure.bilibili.tv/secure,cid="+cid+"&aid="+aid;
	}
	
	@Test
	public void test() {
		System.out.println(getMovieInfoPath("json", "8e9fc618fbd41e28", 850124, 1));
	}
}
