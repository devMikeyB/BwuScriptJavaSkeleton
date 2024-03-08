package net.botwithus;

import net.botwithus.rs3.imgui.ImGui;
import net.botwithus.rs3.imgui.ImGuiWindowFlag;
import net.botwithus.rs3.script.ScriptConsole;
import net.botwithus.rs3.script.ScriptGraphicsContext;

public class SkeletonScriptGraphicsContext extends ScriptGraphicsContext {

    private GemMiner script;

    public SkeletonScriptGraphicsContext(ScriptConsole scriptConsole, GemMiner script) {
        super(scriptConsole);
        this.script = script;
    }

    @Override
    public void drawSettings() {
        if (ImGui.Begin("Mike's Gem Miner, Cutter, Fletcher", ImGuiWindowFlag.None.getValue())) {
            if (ImGui.BeginTabBar("MyTabBar", ImGuiWindowFlag.None.getValue())) {
                if (ImGui.BeginTabItem("Information", ImGuiWindowFlag.None.getValue())) {
                    ImGui.Text("Welcome to Mike's Gem Miner, Cutter, Fletcher!");
                    ImGui.Text("This script will Mine Gems in Al-Kharid, cut them, and fletch them.");
                    ImGui.Text("Banking options are available in the Options pane.");
                    ImGui.Text("My scripts state is: " + script.getBotState());
                    ImGui.EndTabItem();
                }
                if (ImGui.BeginTabItem("Options", ImGuiWindowFlag.None.getValue())) {
                    ImGui.Text("Banking Options");
                    script.setBanking(ImGui.Checkbox("Bank Product", script.getBanking()));
                    ImGui.Text("");
                    ImGui.Text("Mining Options");
                    ImGui.Text("Mining: " + script.getSelectedGemRocks());
                    if (ImGui.Button("Common Gem Rocks")) {
                        script.setGemRocks(String.valueOf(GemMiner.GemRocks.COMMON_ROCK));
                    }
                    if (ImGui.Button("Uncommon Gem Rocks")) {
                        script.setGemRocks(String.valueOf(GemMiner.GemRocks.UNCOMMON_ROCK));
                    }

                    script.setCrafting(ImGui.Checkbox("Cut Gems", script.getCrafting()));
                    script.setFletching(ImGui.Checkbox("Fletch Gems", script.getFletching()));

                    ImGui.EndTabItem();
                }
                ImGui.EndTabBar();
            }
            ImGui.End();
        }

    }

    @Override
    public void drawOverlay() {
        super.drawOverlay();
    }
}
