// swift-tools-version:5.3
import PackageDescription

let package = Package(
    name: "candlestickchart",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "candlestickchart",
            targets: ["candlestickchart"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "candlestickchart",
            url: "https://github.com/Chetansinh-r/LineChart/releases/download/1.0.0/candlestickchart.zip",
            checksum: "052fd534e423bbed1088152b7eb8a7dedda7d4fdb6198b7ca63274395a26b331"
        ),
    ]
)
