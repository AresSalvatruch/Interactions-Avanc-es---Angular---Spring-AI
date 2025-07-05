package org.example.mcpserver.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.annotation.Description;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StockTolls {

    private final List<Company> companies = List.of(
            new Company("Orange", "Telecom", 3.6, 10600, "Maroc"),
            new Company("OCP", "Extraction minière", 5.6, 20000, "Maroc"),
            new Company("Renault Maroc", "Automobile", 4.8, 8000, "Maroc"),
            new Company("Attijariwafa Bank", "Finance", 6.3, 11000, "Maroc"),
            new Company("Amazon", "E-commerce", 513.0, 1_500_000, "USA"),
            new Company("Tesla", "Automobile", 81.5, 99_000, "USA"),
            new Company("Samsung", "Électronique", 244.4, 270_000, "Corée du Sud")
    );

    @Tool(description = "Get all registered companies")
    public List<Company> getAllCompanies() {
        return companies;
    }

    @Tool(description = "Get a company by its name (case-insensitive)")
    public Company getCompanyByName(String companyName) {
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new IllegalArgumentException("Company name must not be null or empty");
        }

        return companies.stream()
                .filter(c -> c.name().equalsIgnoreCase(companyName.trim()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Company '" + companyName + "' not found"));
    }

    @Tool(description = "Get all companies located in a specific country")
    public List<Company> getCompaniesByCountry(String country) {
        if (country == null || country.trim().isEmpty()) {
            return List.of(); // Return empty if input is invalid
        }

        return companies.stream()
                .filter(c -> c.country().equalsIgnoreCase(country.trim()))
                .collect(Collectors.toList());
    }

    @Tool(description = "Get a generated stock value for a given company name")
    public Stock getStockByCompanyName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Company name must not be null or empty");
        }

        return new Stock(name.trim(), LocalDate.now(), 300 + Math.random() * 300);
    }
}

record Company(
        String name,
        String activity,
        @Description("The turnover in billion MAD")
        double turnover,
        int employeesCount,
        String country
) {}

record Stock(
        String companyName,
        LocalDate date,
        double stock
) {}
