# Multi-stage build for Scala/SBT application
# Stage 1: Build the application
FROM eclipse-temurin:17-jdk as builder

# Install sbt
RUN apt-get update && \
    apt-get install -y curl gnupg && \
    echo "deb https://repo.scala-sbt.org/scalasbt/debian all main" | tee /etc/apt/sources.list.d/sbt.list && \
    echo "deb https://repo.scala-sbt.org/scalasbt/debian /" | tee /etc/apt/sources.list.d/sbt_old.list && \
    curl -sL "https://keyserver.ubuntu.com/pks/lookup?op=get&search=0x2EE0EA64E40A89B84B2DF73499E82A75642AC823" | apt-key add && \
    apt-get update && \
    apt-get install -y sbt && \
    rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy build files
COPY build.sbt ./
COPY project ./project

# Download dependencies (layer caching)
RUN sbt update

# Copy source code
COPY src ./src

# Build the application using stage task (creates universal package)
RUN sbt stage

# Stage 2: Runtime image
FROM eclipse-temurin:17-jre-jammy

# Install required libraries
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    curl \
    && rm -rf /var/lib/apt/lists/*

# Create a non-root user
RUN useradd -m -u 1001 appuser

WORKDIR /app

# Copy the staged application from builder
COPY --from=builder --chown=appuser:appuser /app/target/universal/stage /app

# Switch to non-root user
USER appuser

# Expose the default port
EXPOSE 8080

# Set the PORT environment variable (can be overridden)
ENV PORT=8080

# Run the application
CMD ["/app/bin/primenumbers-http4s-scala"]
