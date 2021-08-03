package cn.com.chinasoft.springEvent.diagnostics;

import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;

/**
 * ClassName: MyFailureAnalyzers <br/>
 * Description: <br/>
 * date: 2021/8/1 17:47<br/>
 *
 * @author zhangzhenxing<br />
 */
public class MyFailureAnalyzers implements FailureAnalyzer {

    @Override
    public FailureAnalysis analyze(Throwable failure) {
        if (failure instanceof UnknownError){
            return new FailureAnalysis("未知异常","请重启尝试",failure);
        }
        return null;
    }
}
