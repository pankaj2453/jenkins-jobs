package ci_open_jenkins.build

import javaposse.jobdsl.dsl.DslFactory
import uk.gov.hmrc.jenkinsjobbuilders.domain.builder.BuildMonitorViewBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtFrontendJobBuilder
import uk.gov.hmrc.jenkinsjobs.domain.builder.SbtMicroserviceJobBuilder

new SbtMicroserviceJobBuilder('ated-subscription').
        withTests("test").
        withScalaStyle().
        withSCoverage().
        build(this as DslFactory)

new SbtMicroserviceJobBuilder('agent-client-mandate').
        withScalaStyle().
        withSCoverage().
        build(this as DslFactory)

new SbtFrontendJobBuilder('agent-client-mandate-frontend').
        withScalaStyle().
        withSCoverage().
        build(this as DslFactory)

new BuildMonitorViewBuilder('ATED-MONITOR')
        .withJobs('ated-subscription', 'agent-client-mandate', 'agent-client-mandate-frontend').build(this)
