
# 🧠 TP2 – Interaction Avancée avec MCP, Spring Boot, Python et Ollama

Ce projet est une application complète de démonstration de communication entre plusieurs serveurs intelligents (Java et Python) via le protocole MCP (Multi-Component Protocol), un client central et un frontend en Angular.

## 🔧 Structure du projet

TP2/  
└── mcp-demo-spring-python/  
 ├── chat-frontend/   # Frontend Angular pour l'interface utilisateur  
 ├── mcp-Client/    # Client Java Spring Boot qui communique avec les serveurs MCP  
 ├── mcp-server/    # Serveur Java MCP exposant des outils (tools)  
 ├── python-mcp-server/ # Serveur Python MCP avec ses propres tools  
 ├── pics app/      # Images d'architecture et d'exemples  
 └── pom.xml       # Build Maven principal  

## 💬 Fonctionnalités principales

- Communication client-serveur basée sur le **protocole MCP**  
- **Ollama** pour la génération IA locale  
- **Serveur Java MCP** avec des outils comme :  
  - `getStockByCompanyName`  
  - `getAllCompanies`  
  - `getCompanyByName`  
- **Serveur Python MCP** avec des outils comme :  
  - `get_employee_info` (Nom + Salaire)  
- Connexion **frontend Angular** au client MCP pour interagir avec tous les outils  

## 🧱 Architecture du système

### Schéma global du projet :  

<img src="./images/ExempleArchitechture.png" alt="Arch global" width="700"/>

### Vue simplifiée pour la documentation :  

<img src="./images/ArchApp.png" alt="Arch app" width="700"/>

## 🚀 Démarrage rapide

### 1. Lancer Ollama (localement)  
Assurez-vous qu’Ollama est en cours d’exécution avec le modèle que vous utilisez.

### 2. Lancer le serveur MCP Java  
```bash
cd mcp-server  
./mvnw spring-boot:run  
```

### 3. Lancer le client MCP  
```bash
cd mcp-Client  
./mvnw spring-boot:run  
```  
**NB : Le serveur Python MCP démarrera dès que vous démarrerez le client.**

### 4. Lancer le frontend Angular  
```bash
cd chat-frontend  
npm install  
ng serve  
```

## 🧠 Exemple d’outils disponibles

### Depuis le serveur Java :  
```json
{
  "tool": "getStockByCompanyName",
  "inputSchema": {
    "name": "string"
  }
}
```

### Depuis le serveur Python :  
```json
{
  "tool": "get_employee_info",
  "inputSchema": {
    "name": "string"
  }
}
```

## 📸 Interface et interactions

### Exemple de génération dans le frontend :  

<img src="./images/PremierInterface.png" alt="Premier Interface" width="700"/>

<img src="./images/InterfaceChat.png" alt="Interface chat" width="700"/>

## 🛠️ Technologies utilisées

- `Angular` – Frontend dynamique  
- `Spring Boot` – Client & Serveur Java  
- `Python` – Serveur MCP secondaire  
- `Ollama` – IA locale LLM  
- `MCP` – Protocole d’interaction  

## 📚 Auteur

Ce TP a été réalisé dans le cadre du Master TIW – **Interaction Avancée**  
👤 Ares Salvatruch – [GitHub](https://github.com/AresSalvatruch)
