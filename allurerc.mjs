import { defineConfig } from "allure";

export default defineConfig ({
    name: "Saucedemo UI Automation",
    output: "./target/allure-results",
    historyPath: "./history.jsonl",
    port: 3000,
    open: true,
    environments: {
        Windows: {
            matcher: ({ labels }) =>
                labels.find(({ name, value }) => name === "Operating System" && value === "Windows"),
            variables: {
                "OS": "Windows 11",
                "Architecture": "x64"
            }
        },
        macOS: {
            matcher: ({ labels }) =>
                labels.find(({ name, value }) => name === "Operating System" && value === "macOS"),
            variables: {
                "OS": "macOS Sonoma",
                "Architecture": "arm64"
            }
        },
        Linux: {
            matcher: ({ labels }) =>
                labels.find(({ name, value }) => name === "Operating System" && value === "Linux"),
            variables: {
                "OS": "Ubuntu 24.04",
                "Architecture": "x64"
            }
        }
    }
})