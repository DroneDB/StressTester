
# StressTester

Stress Testing Suite for Registry's API

  

Clone and run test

  

    git clone https://github.com/DroneDB/StressTester.git

    cd stress-test

    docker run -it --rm -v ./conf:/opt/gatling/conf -v ./user-files:/opt/gatling/user-files -v ./results:/opt/gatling/results denvazh/gatling

The results are in the `results` folder as html files