import javaposse.jobdsl.dsl.DslFactory
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtFrontendJobBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtLibraryJobBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtMicroserviceJobBuilder

import static uk.gov.hmrc.jenkinsjobbuilders.domain.publisher.HtmlReportsPublisher.htmlReportsPublisher
import static uk.gov.hmrc.jenkinsjobbuilders.domain.variables.JdkEnvironmentVariable.JDK7

new SbtFrontendJobBuilder('help-frontend').
                         build(this as DslFactory)

new SbtMicroserviceJobBuilder('worldpay-downloader').
						 withTests("test it:test fun:test").	
						 withAdditionalPublisher(htmlReportsPublisher('target/fun-test-reports/cucumber': 'Functional tests HTML Report')).
                         build(this as DslFactory)

new SbtLibraryJobBuilder('worldpay-report-generator', JDK7).
        build(this as DslFactory)

new SbtLibraryJobBuilder('reference-checker', JDK7).
        build(this as DslFactory)

new SbtLibraryJobBuilder('mongo-lock', JDK7).
        build(this as DslFactory)

new SbtLibraryJobBuilder('frontend-bootstrap', JDK7).
        build(this as DslFactory)

new SbtLibraryJobBuilder('play-ui', JDK7).
        build(this as DslFactory)

new SbtLibraryJobBuilder('play-partials', JDK7).
        build(this as DslFactory)

new SbtLibraryJobBuilder('play-url-binders', JDK7).
        build(this as DslFactory)
