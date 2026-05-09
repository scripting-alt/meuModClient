# Meu Mod Client - Minecraft 1.12.2

Um mod cliente simples e configurável com menu e sistema de scaffold automático.

## Funcionalidades

✅ **Menu Configurável** - Abra com `SHIFT + Clique Direito`
- Ativar/Desativar Scaffold
- Configurar alcance do Scaffold (1-20 blocos)
- Ativar/Desativar Partículas
- Ativar/Desativar Som

✅ **Sistema de Scaffold** - Coloca blocos automaticamente sob os pés quando está andando

✅ **Configurações Salvas** - Arquivo `meumodclient.cfg`

## Instalação

1. Baixe o arquivo `.jar` compilado
2. Coloque em `%appdata%/.minecraft/mods/` (Windows) ou `~/.minecraft/mods/` (Linux/Mac)
3. Abra o Minecraft com Forge 1.12.2
4. Jogue!

## Como Compilar

```bash
./gradlew build
```

O arquivo `.jar` estará em `build/libs/meuModClient-1.0.0.jar`

## Controles

- **SHIFT + Clique Direito** = Abrir Menu
- **Menu** = Configurar opções

## Configuração

Edite `config/meumodclient.cfg` para customizar:

```
scaffoldEnabled=true
scaffoldRange=5
particlesEnabled=true
soundEnabled=true
```

## Desenvolvido por

scripting-alt

---

**Minecraft 1.12.2 | Forge 14.23.5.2847**