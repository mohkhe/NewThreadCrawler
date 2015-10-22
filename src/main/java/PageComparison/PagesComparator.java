package PageComparison;

import java.util.LinkedList;
import java.util.Set;

import PageComparison.diff_match;
import PageComparison.diff_match.Diff;

public class PagesComparator {
	String pageOnehtml;
	String pageOneText;
	String pageTwohtml;
	String pageTwoText;
	diff_match diff = new diff_match();

	public void setPageOne(String pageOnehtml, String pageOnetext) {
		this.pageOnehtml = pageOnehtml;
		this.pageOneText = pageOnetext;
	}

	public void setPageTwo(String pageTwohtml, String pageTwotext) {
		this.pageTwohtml = pageTwohtml;
		this.pageTwoText = pageTwotext;
	}

	// are you simply checking for the presence of specific fields or other UI
	// elements? Is their order significant? Is their appearance significant?
	// Do you want to compare the DOM, the text, or what?
	public boolean changedMethodTEXT() {// text
		if (pageTwoText.equalsIgnoreCase(pageOneText)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean changedMethod2HTML() {// html
		if (pageTwohtml.equalsIgnoreCase(pageOnehtml)) {
			return false;
		} else {
			return true;
		}
	}

	public boolean changedMethod_diffText() {// extra package to compare html pages
		LinkedList<Diff> linkedListDiff = diff.diff_main(pageOneText,
				pageTwoText);
	/*	int differentChars = diff.diff_levenshtein(linkedListDiff);
		String [] a = diff.diff_halfMatch(pageOneText, pageTwoText);*/
		
		if(linkedListDiff!= null){
			if(linkedListDiff.isEmpty()){
				return false;
			}else {
				return true;
			}
		}else{
			System.out.println("Text linkedListDiff is null.");
			return false;
		}
		
	}
	
	public boolean changedMethod_diffHtml() {// extra package to compare html pages
		LinkedList<Diff> linkedListDiff = diff.diff_main(pageOnehtml,
				pageTwohtml);
		if(linkedListDiff!= null){
			if(linkedListDiff.isEmpty()){
				return false;
			}else 
				return true;
		}else{
			System.out.println("HTML linkedListDiff is null.");
			return false;
		}
		
	}
	public boolean changedMethod_diff_Chars100() {// extra package to compare html pages
		LinkedList<Diff> linkedListDiff;
		linkedListDiff = diff.diff_main(pageOneText,
				pageTwoText);
		int differentChars = diff.diff_levenshtein(linkedListDiff);
		
			if(differentChars<100){
				return false;
			}else {
				return true;
			}
	}
	
	public boolean changedMethod_shingle() {// extra package to compare html pages
		Set<String> pageOneShingleSet = new Shingle().shingles(pageOneText);
		Set<String> pageTwoShingleSet = new Shingle().shingles(pageTwoText);
		float difference = new Shingle().jaccard_similarity_coeff(pageOneShingleSet, pageTwoShingleSet);
			if(difference > 0.9  || Float.isNaN(difference)){//NaN both are empty
				return false;
			}else {
				return true;
			}
	}

	public void resetValues() {
		pageOnehtml = "";
		pageOneText = "";
		pageTwohtml = "";
		pageTwoText = "";
		
	}

}
