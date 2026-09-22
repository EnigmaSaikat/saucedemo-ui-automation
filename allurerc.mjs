import { defineConfig } from "allure";

export default {
    name: "Saucedemo UI Automation",
    output: "./target/allure-report",
    historyPath: "./history.jsonl",
    open: false,
    port: "3000",

    environments: {
        Windows: {
            matcher: ({ labels = [] }) =>
                labels.some(({ name, value }) =>
                    name === "Operating System" && value === "Windows"
                ),
            variables: {
                OS: "Windows 11",
                Architecture: "x64"
            }
        },

        macOS: {
            matcher: ({ labels = [] }) =>
                labels.some(({ name, value }) =>
                    name === "Operating System" && value === "macOS"
                ),
            variables: {
                OS: "macOS Sonoma",
                Architecture: "arm64"
            }
        },

        Linux: {
            matcher: ({ labels = [] }) =>
                labels.some(({ name, value }) =>
                    name === "Operating System" && value === "Linux"
                ),
            variables: {
                OS: "Ubuntu 24.04",
                Architecture: "x64"
            }
        }
    }
};