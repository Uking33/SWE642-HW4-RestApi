package cs.yli66.swe642.resources;

public class DataProcessor {
	private int numArr[];
	private DataBean data;
    public DataProcessor(String numString) {
    	data = new DataBean();
		if(numString==null || numString.isEmpty()) {
			return;
		}
		String arr[] = numString.split(",");
		if(arr.length == 0) {
			return;
		}
		this.numArr = new int[arr.length];
    	for(int i = 0;i<arr.length;i++){
        	this.numArr[i] = Integer.parseInt(arr[i]);
    	}
    	float sum;
    	if(this.numArr.length > 0) {
    		//Mean
    		sum = 0;
    		for (int i=0;i<this.numArr.length;i++) {
    			sum += this.numArr[i];
    		}
    		sum /= this.numArr.length;
    		data.setMean(sum);
    		//StandardDeviation
    		sum = 0;
    		for (int i=0;i<this.numArr.length;i++) {
    			float t = this.numArr[i] - data.getMean();
    			sum += t * t;
    		}
    		data.setStandardDeviation(sum);
    	}
    }
    public DataBean getData() {
    	return data;
    }
}
