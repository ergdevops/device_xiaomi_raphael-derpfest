repo sync -c --force-sync --optimized-fetch --no-tags --no-clone-bundle --prune -j$(nproc --all)
cd frameworks/base
git fetch https://github.com/amanrajOO7/frameworks_base 6103d74df29c5da8e9880bf33889e4dda847e8cf && git cherry-pick 6103d74df29c5da8e9880bf33889e4dda847e8cf
cd ../..

