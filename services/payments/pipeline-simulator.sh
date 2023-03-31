echo "[DEBUG] pipeline simulator"
echo "[DEBUG] current directory: $(pwd)"
echo "[DEBUG] git version $(git version)"
echo "[DEBUG] docker version: $(docker --version)"
echo "[DEBUG] maven version: $(mvn --version)"

NAMESPACE="payment"
SERVICE_NAME="payment-service"
DOCKER_USERNAME=$1
DOCKER_ACCESS_TOKEN=$2
DOCKER_HUB_REPOSITORY=$3
BUILD_VERSION=$4
HELM_VALUES_PATH=$5

echo "[DEBUG] Checkout java-pipeline-templates"
git clone https://github.com/CuongDang-DevSecOps/java-pipeline-templates

# CI

## Maven Test
sh java-pipeline-templates/ci/maven-test.sh

## Maven Build
sh java-pipeline-templates/ci/maven-build.sh

## Docker Build
sh java-pipeline-templates/ci/docker-build.sh "$SERVICE_NAME"

## Docker Push
sh java-pipeline-templates/ci/docker-push.sh "$SERVICE_NAME" "$DOCKER_USERNAME" "$DOCKER_ACCESS_TOKEN" "$DOCKER_HUB_REPOSITORY" "$BUILD_VERSION"

# CD

## Render K8S Manifest
echo "[DEBUG] Checkout helm-chart-templates"
git clone https://github.com/CuongDang-DevSecOps/helm-chart-templates

sh java-pipeline-templates/cd/k8s-render-manifest.sh "$BUILD_VERSION" "$HELM_VALUES_PATH"

## GitOps Push Changes
echo "[DEBUG] Checkout git-ops"
git clone https://github.com/CuongDang-DevSecOps/git-ops

sh java-pipeline-templates/cd/gitops-push-changes.sh "$BUILD_VERSION" "$NAMESPACE" "$SERVICE_NAME"

echo "[DEBUG] Clean Up"
rm -rf java-pipeline-templates
rm -rf helm-chart-templates
rm -rf git-ops