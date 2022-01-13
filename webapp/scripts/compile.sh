#!/bin/sh

yarn remove KMMPlaygground-shared
yarn add file:../shared/build/dist
yarn start
