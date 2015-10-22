package db.infiniti.config;

public class QueryResStatistics {

	int qPosedIndex= 0;
	int uniqResults= 0;
	int RepeatedResultsLocally= 0;
	int RepeatedResultsGeneral= 0;
	
	int totalResultsEachQuery= 0; 
	int ResultsEachQueryPreviousRun = 0;
	int numCompletelyNewLinksComparePreviousCrawl= 0;
	int numNewLinksInQueryResults= 0;//in comparison to previous try for that query
	int numSameURLChangedText= 0;
	
	QueryResStatistics(int qPosedIndex,	int uniqResults,	int RepeatedResults, int RepeatedResultsGeneral, 
			int totalResultsEachQuery, int ResultsEachQueryPreviousRun, int numCompletelyNewLinksComparePreviousCrawl2,
			int numNewLinksInQueryResults2, int numSameURLChangedText2){
		this.qPosedIndex = qPosedIndex;
		this.uniqResults = uniqResults;
		this.RepeatedResultsLocally = RepeatedResults;
		this.RepeatedResultsGeneral = RepeatedResultsGeneral;
		this.totalResultsEachQuery = totalResultsEachQuery;
		this.ResultsEachQueryPreviousRun = ResultsEachQueryPreviousRun;
		this.numCompletelyNewLinksComparePreviousCrawl = numCompletelyNewLinksComparePreviousCrawl2;
		this.numNewLinksInQueryResults = numNewLinksInQueryResults2;//in comparison to previous try for that query
		this.numSameURLChangedText = numSameURLChangedText2;
	}

	public int getqPosedIndex() {
		return qPosedIndex;
	}

	public void setqPosedIndex(int qPosedIndex) {
		this.qPosedIndex = qPosedIndex;
	}

	public int getUniqResults() {
		return uniqResults;
	}

	public void setUniqResults(int uniqResults) {
		this.uniqResults = uniqResults;
	}

	public int getRepeatedResults() {
		return RepeatedResultsLocally;
	}

	public void setRepeatedResultsGeneral(int repeatedResults) {
		RepeatedResultsGeneral = repeatedResults;
	}
	public int getRepeatedResultsGeneral() {
		return RepeatedResultsGeneral;
	}

	public void setRepeatedResults(int repeatedResults) {
		RepeatedResultsLocally = repeatedResults;
	}
	public int gettotalResultsEachQuery() {
		return totalResultsEachQuery;
	}

	public void settotalResultsEachQuery(int repeatedResults) {
		totalResultsEachQuery = repeatedResults;
	}
	
	public int getNumCompletelyNewLinksComparePreviousCrawl() {
		return numCompletelyNewLinksComparePreviousCrawl;
	}

	public void setNumCompletelyNewLinksComparePreviousCrawl(
			int numCompletelyNewLinksComparePreviousCrawl) {
		this.numCompletelyNewLinksComparePreviousCrawl = numCompletelyNewLinksComparePreviousCrawl;
	}

	public int getNumNewLinksInQueryResults() {
		return numNewLinksInQueryResults;
	}

	public void setNumNewLinksInQueryResults(int numNewLinksInQueryResults) {
		this.numNewLinksInQueryResults = numNewLinksInQueryResults;
	}

	public int getNumSameURLChangedText() {
		return numSameURLChangedText;
	}

	public void setNumSameURLChangedText(int numSameURLChangedText) {
		this.numSameURLChangedText = numSameURLChangedText;
	}

	public double gettotalResultsEachQueryPreviousRun() {
		// TODO Auto-generated method stub
		return ResultsEachQueryPreviousRun;
	}

	
}
