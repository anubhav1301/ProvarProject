package customapis;


import java.util.logging.Logger;

import com.provar.core.model.base.api.ValueScope;
import com.provar.core.testapi.ITestExecutionContext;
import com.provar.core.testapi.annotations.*;

@TestApi( title="Print_Cust_API"
        , summary="This API can be used to print value of any variable"
        , remarks=""
        , iconBase=""
        , defaultApiGroups={"Custom"}
        )
@TestApiParameterGroups(parameterGroups={
	    @TestApiParameterGroup(groupName="inputs", title="Inputs"),
	    @TestApiParameterGroup(groupName="result", title="Result"),
	    })
public class Print {
    
    @TestApiParameter(seq=1, 
            summary="Input variable name or string",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String InputValue;
    
    @TestApiParameter(seq=2, 
            summary="Input message to be displayed",
            remarks="",
            mandatory=true,
            parameterGroup="inputs")
    public String OutputMessage;

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
    	testLogger.info(OutputMessage+": " + InputValue);

        // Store the result (if appropriate).
    	String dummyResult = this.getClass().getName() + " result";
        testExecutionContext.setValue(resultName, InputValue, resultScope);
        
    }
    
}
