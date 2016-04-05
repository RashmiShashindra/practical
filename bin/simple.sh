#!/bin/sh

GIT_DIR_="$(git rev-parse --git-dir)"

echo GIT_DIR_

BRANCH="$(git rev-parse --symbolic --abbrev-ref $(git symbolic-ref HEAD))"

echo BRANCH

POST_PUSH="$GIT_DIR_/hooks/post-push"

echo POST_PUSH

ENV=$env

git push "$@"

echo "$@"

curl --user 'commituser:1qaz2wsx@' -X POST "http://10.101.15.21:8080/jenkins/job/ZTAF-Ui-Core-Deploy/build" --data token=authtoken --data delay=0sec

