package patches.buildTypes

import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.CommitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildFeatures.commitStatusPublisher
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.NuGetPublishStep
import jetbrains.buildServer.configs.kotlin.v2019_2.buildSteps.nuGetPublish
import jetbrains.buildServer.configs.kotlin.v2019_2.ui.*

/*
This patch script was generated by TeamCity on settings change in UI.
To apply the patch, change the buildType with id = 'PublishToFeedzIo'
accordingly, and delete the patch script.
*/
changeBuildType(RelativeId("PublishToFeedzIo")) {
    expectSteps {
        nuGetPublish {
            name = "Nuget Publish"
            toolPath = "%teamcity.tool.NuGet.CommandLine.DEFAULT%"
            packages = "*.nupkg"
            serverUrl = "%InternalNuget.OctopusDependeciesFeedUrl%"
            apiKey = "%nuGetPublish.apiKey%"
            args = "-Timeout 1200"
        }
    }
    steps {
        update<NuGetPublishStep>(0) {
            clearConditions()
            apiKey = "credentialsJSON:21016b86-e16b-4825-ab03-02ec2d979b7f"
        }
    }

    features {
        val feature1 = find<CommitStatusPublisher> {
            commitStatusPublisher {
                publisher = github {
                    githubUrl = "https://api.github.com"
                    authType = personalToken {
                        token = "%commitStatusPublisher.apiKey%"
                    }
                }
            }
        }
        feature1.apply {
            publisher = github {
                githubUrl = "https://api.github.com"
                authType = personalToken {
                    token = "credentialsJSON:d2d6ff31-56f1-4893-a448-f7a517da6c88"
                }
            }
        }
    }

    dependencies {
        expect(RelativeId("NetcoreTesting_AmazonLinux")) {
            snapshot {
            }
        }
        update(RelativeId("NetcoreTesting_AmazonLinux")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("NetcoreTesting_Ubuntu")) {
            snapshot {
            }
        }
        update(RelativeId("NetcoreTesting_Ubuntu")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("NetcoreTesting_OpenSUSE")) {
            snapshot {
            }
        }
        update(RelativeId("NetcoreTesting_OpenSUSE")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        remove(RelativeId("NetcoreTesting_Sles")) {
            snapshot {
            }
        }

        expect(RelativeId("NetcoreTesting_CentOS")) {
            snapshot {
            }
        }
        update(RelativeId("NetcoreTesting_CentOS")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("NetcoreTesting_Fedora")) {
            snapshot {
            }
        }
        update(RelativeId("NetcoreTesting_Fedora")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("NetcoreTesting_Debian")) {
            snapshot {
            }
        }
        update(RelativeId("NetcoreTesting_Debian")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("NetcoreTesting_Rhel")) {
            snapshot {
            }
        }
        update(RelativeId("NetcoreTesting_Rhel")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("NetcoreTesting_Windows")) {
            snapshot {
            }
        }
        update(RelativeId("NetcoreTesting_Windows")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        remove(RelativeId("NetcoreTesting_MacOsx")) {
            snapshot {
            }
        }

        remove(RelativeId("WindowsNetFxTesting_2008r2")) {
            snapshot {
            }
        }

        expect(RelativeId("WindowsNetFxTesting_2012")) {
            snapshot {
            }
        }
        update(RelativeId("WindowsNetFxTesting_2012")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("WindowsNetFxTesting_2012r2")) {
            snapshot {
            }
        }
        update(RelativeId("WindowsNetFxTesting_2012r2")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("WindowsNetFxTesting_2016")) {
            snapshot {
            }
        }
        update(RelativeId("WindowsNetFxTesting_2016")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

        expect(RelativeId("WindowsNetFxTesting_2019")) {
            snapshot {
            }
        }
        update(RelativeId("WindowsNetFxTesting_2019")) {
            snapshot {
                reuseBuilds = ReuseBuilds.NO
            }
        }

    }
}
