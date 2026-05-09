# Meu Mod Client - Minecraft 1.12.2

Um mod cliente avançado com menu customizável e múltiplas funções.

## 🎮 Funcionalidades

✅ **Menu Avançado** - Abra com `RIGHT-SHIFT`
- Scaffold ON/OFF - Coloca blocos automaticamente
- ESP ON/OFF - Mostra inimigos e players em vermelho
- NoFall ON/OFF - Remove damage de queda
- Speed ON/OFF - Aumenta velocidade de movimento
- Nightvision ON/OFF - Visão noturna
- Fly ON/OFF - Voo (apenas cliente)
- Atirador Automático ON/OFF - Tira fotos automaticamente
- AntiKnockback ON/OFF - Reduz knockback recebido
- Configurar alcance e velocidade
- Salvar todas as configurações

## 📥 Instalação

1. Baixe o arquivo `meuModClient-1.0.0.jar`
2. Coloque em `%appdata%/.minecraft/mods/` (Windows) ou `~/.minecraft/mods/` (Linux/Mac)
3. Abra o Minecraft com Forge 1.12.2
4. Jogue!

## 🔧 Como Compilar

```bash
./gradlew build
```

O arquivo `.jar` estará em `build/libs/meuModClient-1.0.0.jar`

## 🎮 Controles

- **RIGHT-SHIFT** = Abrir Menu Principal
- **ESC** = Fechar Menu

## ⚙️ Configuração

Edite `config/meumodclient.cfg` para customizar:

```
scaffoldEnabled=true
scaffoldRange=5
espEnabled=false
nofallEnabled=false
speedEnabled=false
nightvisionEnabled=false
flyEnabled=false
shooterEnabled=false
antiKnockbackEnabled=false
```

## ⚠️ Aviso

- Este mod é apenas para CLIENTE
- Use por sua conta e risco em servidores
- Alguns recursos podem ser detectados em anti-cheats
- Desenvolvido para fins educacionais

## Desenvolvido por

scripting-alt

---

**Minecraft 1.12.2 | Forge 14.23.5.2847**