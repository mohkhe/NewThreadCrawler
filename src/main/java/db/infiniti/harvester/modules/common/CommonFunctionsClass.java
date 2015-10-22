package db.infiniti.harvester.modules.common;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;

public class CommonFunctionsClass {
	HashSet<String> listOfStopWords;
	
	
	public boolean isStopWord(String query) {
		if (listOfStopWords == null) {
			setListOfStopWords();
		}
		if (listOfStopWords.contains(query)) {
			return true;
		}
		return false;
	}
	//define the set of stopwords here
	HashSet<String> setListOfStopWords() {
		listOfStopWords.add("the");
		listOfStopWords.add("a");
		listOfStopWords.add("an");
		listOfStopWords.add("of");
		listOfStopWords.add("in");
		listOfStopWords.add("and");
		listOfStopWords.add("is");
		listOfStopWords.add("to");
		listOfStopWords.add("at");
		listOfStopWords.add("on");
		listOfStopWords.add("as");
		listOfStopWords.add("not");
		listOfStopWords.add("from");
		listOfStopWords.add("by");
		listOfStopWords.add("for");
		listOfStopWords.add("you");
		listOfStopWords.add("your");
		listOfStopWords.add("one");
		listOfStopWords.add("up");
		listOfStopWords.add("us");
		listOfStopWords.add("other");
		listOfStopWords.add("others");
		listOfStopWords.add("over");
		listOfStopWords.add("home");
		listOfStopWords.add("our");
		listOfStopWords.add("first");
		
		listOfStopWords.add("het");
		listOfStopWords.add("de");
		listOfStopWords.add("en");
		listOfStopWords.add("met");
		listOfStopWords.add("andere");
		listOfStopWords.add("tussen");
		listOfStopWords.add("van");
		listOfStopWords.add("een");
		listOfStopWords.add("pagina");
		listOfStopWords.add("deze");
		
		listOfStopWords.add("can");
		listOfStopWords.add("could");
		listOfStopWords.add("have");
		listOfStopWords.add("had");
		listOfStopWords.add("will");
		listOfStopWords.add("would");
		listOfStopWords.add("there");
		listOfStopWords.add("with");
		listOfStopWords.add("wikipedia");
		listOfStopWords.add("wikimedia");
		listOfStopWords.add("also");
		listOfStopWords.add("org");
		listOfStopWords.add("here");
		listOfStopWords.add("there");
		listOfStopWords.add("data");
		listOfStopWords.add("that");
		listOfStopWords.add("this");
		listOfStopWords.add("these");
		listOfStopWords.add("those");
		listOfStopWords.add("me");
		listOfStopWords.add("her");
		listOfStopWords.add("his");
		listOfStopWords.add("world");
		listOfStopWords.add("at");
		listOfStopWords.add("was");
		listOfStopWords.add("were");
		listOfStopWords.add("page");
		listOfStopWords.add("new");
		listOfStopWords.add("all");
		listOfStopWords.add("also");
		listOfStopWords.add("public");
		listOfStopWords.add("next");
		listOfStopWords.add("last");
		listOfStopWords.add("book");
		listOfStopWords.add("than");
		listOfStopWords.add("which");
		listOfStopWords.add("when");
		listOfStopWords.add("see");
		listOfStopWords.add("many");
		listOfStopWords.add("has");
		listOfStopWords.add("are");
		listOfStopWords.add("com");
		listOfStopWords.add("or");
		listOfStopWords.add("more");
		listOfStopWords.add("be");
		listOfStopWords.add("its");
		listOfStopWords.add("data");
		listOfStopWords.add("please");
		listOfStopWords.add("http");
		listOfStopWords.add("links");
		listOfStopWords.add("their");
		listOfStopWords.add("page");
		listOfStopWords.add("about");
		listOfStopWords.add("high");
		listOfStopWords.add("must");
		listOfStopWords.add("see");
		listOfStopWords.add("book");
		return listOfStopWords;
	}
	//set list of stop words with a given set
	public void setListOfStopWords(HashSet<String> listOfStopWords) {
		this.listOfStopWords = listOfStopWords;
	}
	
	public String refineText(String pageContent){
		if (pageContent.contains("\n")){
			pageContent = pageContent.replaceAll("\n", " ");
		}
/*		if (pageContent.matches("[.,!?:;'\"-]")){
			pageContent = pageContent.replaceAll("\\p{punct}+", " ");
		}
		if (pageContent.contains("\\p{Punct}")){
			pageContent = pageContent.replaceAll("\\p{Punct}", " ");
		}*/
		if (pageContent.contains("\\") || pageContent.contains(":") || pageContent.contains(";") || pageContent.contains(".")){
			pageContent = pageContent.replaceAll("\\p{Punct}", " ");
		}
		return pageContent.trim();
	}
	
	public String[] tokenizer(String content) {
		String delims = "[+\\-*/\\^ .,?!:;=()]+";
		String[] tokens = content.split(delims);
		return tokens;
	}
	
	/**
	 * @param originalURL
	 * @param linkedPath
	 * @return completed form of URL (with http) by Victor
	 */
	public String getLinkedURL(String originalURL, String linkedPath) {
		URL origURL = null;
		try {
			origURL = new URL(originalURL);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		if (linkedPath.startsWith("/")) {
			String portSuffix = origURL.getPort() == -1 ? "" : ":"
					+ origURL.getPort();
			linkedPath = origURL.getProtocol() + "://" + origURL.getHost()
					+ portSuffix + linkedPath;
		} else if (!linkedPath.startsWith("http")) {
			String originalUrlString = origURL.toString();
			linkedPath = originalUrlString.substring(0,
					originalUrlString.lastIndexOf("/") + 1)
					+ linkedPath;
		}
		return linkedPath;
	}
}
