
# StressTester

Stress Testing Suite for Registry's API

==Dont forget to change the host address in the `.scala` files to reflect  your environment. It should be reachable from the docker container and point to the Registry instance.==

**Clone and run share test**
Default ramp of 30 users in 60 seconds

  

    git clone https://github.com/DroneDB/StressTester.git stress-tester

    cd stress-tester

    docker run -it --rm -v ./conf:/opt/gatling/conf -v ./user-files:/opt/gatling/user-files -v ./results:/opt/gatling/results denvazh/gatling

The results are in the `results` folder as `.html` files, open `index.html` to see them