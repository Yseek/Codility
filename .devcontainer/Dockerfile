# Java 21을 포함하는 공식 OpenJDK 이미지 사용
FROM eclipse-temurin:21-jdk AS build-env

# 시스템 패키지 설치
RUN apt-get update && apt-get install -y \
    curl \
    git \
    unzip \
    gnupg \
    && rm -rf /var/lib/apt/lists/*

# NVM 및 Node.js 설치
ENV NVM_DIR=/root/.nvm
RUN curl -o- https://raw.githubusercontent.com/nvm-sh/nvm/v0.39.4/install.sh | bash && \
    . "$NVM_DIR/nvm.sh" && \
    nvm install --lts && \
    nvm alias default node && \
    npm install -g gitmoji-cli

# 작업 디렉토리 설정
WORKDIR /workspace