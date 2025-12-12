# Docker Deployment Guide

This project uses SBT Native Packager with the Docker plugin for containerized deployment.

## Building the Docker Image

Build the Docker image using SBT:

```bash
# Build image locally
sbt docker:publishLocal

# Or build and push to Docker Hub (set DOCKER_USERNAME env var first)
export DOCKER_USERNAME=your-dockerhub-username
sbt docker:publish
```

The image will be tagged as:
- `$DOCKER_USERNAME/primenumbers-http4s-scala:0.0.4-SNAPSHOT`
- `$DOCKER_USERNAME/primenumbers-http4s-scala:latest`

## Running the Container

### Using Docker directly

Run the container with:

```bash
docker run -d -p 8080:8080 --name primenumbers primenumbers-http4s-scala:0.0.4-SNAPSHOT
```

To run on a different port:

```bash
docker run -d -p 3000:3000 -e PORT=3000 --name primenumbers primenumbers-http4s-scala:0.0.4-SNAPSHOT
```

## Container Management

### Stop the container
```bash
docker stop primenumbers
```

### Start the container
```bash
docker start primenumbers
```

### Remove the container
```bash
docker rm primenumbers
```

### View logs
```bash
docker logs -f primenumbers
```

## Testing the Application

Once the container is running, test the application:

```bash
curl http://localhost:8080/
```

## Deployment Options

### Cloud Platforms

This Docker container can be deployed to various cloud platforms:

- **AWS**: Elastic Container Service (ECS), Elastic Kubernetes Service (EKS), or App Runner
- **Google Cloud**: Cloud Run, Google Kubernetes Engine (GKE), or Compute Engine
- **Azure**: Container Instances, Azure Kubernetes Service (AKS), or App Service
- **DigitalOcean**: App Platform or Kubernetes
- **Heroku**: Container Registry and Runtime

### Example: Deploy to Render.com

1. Connect your GitHub repository to Render
2. Create a new Web Service
3. Render will automatically detect and build from SBT
4. Or use Docker: Set build command to `sbt docker:stage` and use the generated image

### Example: Manual Docker Hub Deployment

```bash
# Set your Docker Hub username
export DOCKER_USERNAME=your-dockerhub-username

# Build and push to Docker Hub
sbt docker:publish

# Pull and run on any server
docker pull $DOCKER_USERNAME/primenumbers-http4s-scala:latest
docker run -d -p 8080:8080 $DOCKER_USERNAME/primenumbers-http4s-scala:latest
```

## Environment Variables

## SBT Docker Commands

```bash
# Show generated Dockerfile
sbt docker:stage

# Build image locally (don't push)
sbt docker:publishLocal

# Build and push to Docker Hub
sbt docker:publish

# Clean Docker artifacts
sbt docker:clean
```

## Configuration

Docker settings are configured in `build.sbt`:
- Base image: `eclipse-temurin:25-jre` (Java SE 25)
- Exposed port: 8080
- Username: Set via `DOCKER_USERNAME` environment variable

## Notes

- The container runs as a non-root user (daemon) for security
- The image is automatically optimized by sbt-native-packager
- Java SE 25 JRE is used for the runtime environment
- No manual Dockerfile needed - everything is managed by SBTyml
- The image uses a multi-stage build to minimize the final image size
- Java 17 JRE is used for the runtime environment
