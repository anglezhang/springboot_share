package cn.com.chinasoft.springEvent.diagnostics;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalysisReporter;
import org.springframework.util.StringUtils;

/**
 * ClassName: MyFailureAnalysisReporter <br/>
 * Description: <br/>
 * date: 2021/7/27 22:00<br/>
 *
 * @author zhangzhenxing<br />
 */
public final class MyFailureAnalysisReporter implements FailureAnalysisReporter {

    private static final Log logger = LogFactory
            .getLog(MyFailureAnalysisReporter.class);
    @Override
    public void report(FailureAnalysis failureAnalysis) {
        if (logger.isErrorEnabled()) {
            logger.error(buildMessage(failureAnalysis));
        }
    }

    private String buildMessage(FailureAnalysis failureAnalysis) {
        StringBuilder builder = new StringBuilder();
        builder.append("send error report to allen %n");
        builder.append(String.format("**************  AX  *************%n"));
        if (StringUtils.hasText(failureAnalysis.getDescription())) {
            builder.append(String.format("%nAction:%n%n"));
            builder.append(String.format("%s%n", failureAnalysis.getAction()));
            builder.append(String.format("%s%n", failureAnalysis.getCause()));
        }
        return builder.toString();
    }
}
