package customapis;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="Sort Ascending_cust_API"
        , summary=""
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class SortAscending {
    
    @TestApiParameter(seq=1, 
            summary="Input Parameter Here",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String InputString;
    

    @TestApiParameter(seq=10, 
            summary="The name that the result will be stored under.",
            remarks="",
            mandatory=true,
            parameterGroup="result")
    public String resultName;

    @TestApiParameter(seq=11, 
            summary="The lifespan of the result.",
            remarks="",
            mandatory=true,
            parameterGroup="result",
            defaultValue="Test")
    public ValueScope resultScope;

    /** 
     * Used to write to the test execution log.
     */
    @TestLogger
    public Logger testLogger;
    
    /** 
     * Provides access to facilities, mainly to set and get variable values.
     */
    @TestExecutionContext
    public ITestExecutionContext testExecutionContext;
    
    @TestApiExecutor
    public void execute() {

    	// Put our implementation logic here.
    	testLogger.info("Hello from " + this.getClass().getName());
    	
    	String[] t1 = InputString.split(",");
    	String tempstr;
    	for(int t=0;t<t1.length-1;t++) {
    		for(int i=0;i<t1.length-t-1;i++) {
    			if(t1[i+1].compareTo(t1[i])<0) {
    				tempstr=t1[i];
    				t1[i]=t1[i+1];
    				t1[i+1]=tempstr;
    			}
    		}
    	}
         List<String> list = new ArrayList<String>(t1.length);
         for(int i=0;i<t1.length;i++) {
        	 list.add(i,t1[i]);
         }
        // Store the result (if appropriate).
    	//String dummyResult = this.getClass().getName() + " result";
        testExecutionContext.setValue(resultName, list, resultScope);
        
    }
    
}
