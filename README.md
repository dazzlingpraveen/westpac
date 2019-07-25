# westpac

How to run:

1. Open the build.gradle file using IDEA or Eclipse. Gradle will sync the project 
2. Create a run configuration: -Dcucumber.options='--tags "@Westpac"' -Denv=st (or) create a run configuration: -Denv=st
3. Click the run button 

If you have gradle in the system: gradle -Dcucumber.options='--tags "@Westpac"' -Denv=st (or) gradle -Denv=st

If there are proxy issues, please create a gradle.properties file at the project directory level and add properties like specified in the below link,

Doc: https://docs.gradle.org/current/userguide/build_environment.html#sec:accessing_the_web_via_a_proxy

Additional points:

1. Tests are built using Intellij IDEA on a macbook 
2. A run screencast has been added 
3. Run config image added
